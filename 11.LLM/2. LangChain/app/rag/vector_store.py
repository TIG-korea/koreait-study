from langchain_community.vectorstores import FAISS
from langchain_openai import OpenAIEmbeddings

def build_vector_store(docs):
    # 매개변수로 전달받은 document list를 벡터로 변환
    embeddings = OpenAIEmbeddings()

    # 로컬 벨터 인덱스 생성
    return  FAISS.from_documents(docs, embeddings)