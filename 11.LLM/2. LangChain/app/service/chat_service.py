from langchain_core.output_parsers import  StrOutputParser
from langchain_core.prompts import ChatPromptTemplate
from  app.core.llm import get_llm
from app.rag.rag_chain import create_rag_chain
from langchain_core.runnables.history import RunnableWithMessageHistory
from langchain_community.chat_message_histories import ChatMessageHistory

# 세션별 대화 히스토리 저장소
store = {}

def get_session_history(session_id: str) -> ChatMessageHistory:
    if session_id not in store:
        store[session_id] = ChatMessageHistory()
    return store[session_id]


class ChatService:

    def __init__(self):
        self.llm = get_llm()
        self.chain = self._create_chain()
        self.rag_chain = create_rag_chain(doc_path="data/sample.txt")

    # 멤버 변수나 함수에 붙는 언더바(_) 의미
    #   -   언더바 (_) 1개는 관례적으로 private으로 사용하겠다. 라는 의미를 가짐
    #       단, 강제되지는 않고 개발자 끼리의 약속
    #   -   언더바(_) 2개는 실제로 private 처럼 동작함
    #       내부적으로 name mangling을 진행함
    def _create_chain(self):

        prompt = ChatPromptTemplate.from_template(
            """
                당신은 백엔드 엔지니어입니다.
                아래 질문에 대해 명확하게 설명하세요.
                
                질문: {question}
                
            """
        )

        chain = prompt | self.llm | StrOutputParser()
        return chain

    def generate(self, question: str):
        return self.chain.invoke({"question": question})

    def stream(self, question: str):
        for chunk in self.chain.stream({"question": question}):
            yield chunk

    def generate_rag(self, question: str):
        # 히스토리 직접 꺼내기
        history = get_session_history("fixed_session")

        # 체인 실행 시 chat_history 직접 주입
        result = self.rag_chain.invoke({
            "question": question,
            "chat_history": history.messages  # ← 직접 전달
        })

        # 대화 기록 수동 저장
        history.add_user_message(question)
        history.add_ai_message(result)

        return result