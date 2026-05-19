from app.rag.loader import load_document
from app.rag.splitter import get_splitter
from app.rag.vector_store import build_vector_store

def create_retriever(doc_path:str, k: int=3):

    # 실제 문서 파일을 읽어서 Document 리스트로 변환
    raw_docs = load_document(doc_path)

    # 적절한 크기의 chunk로 분할하는 과정
    splitter = get_splitter()
    split_docs = splitter.split_documents(raw_docs)

    # Embedding 생성
    #   - 분할한 chunk를 벡터화
    vectorstore = build_vector_store(split_docs)

    # 사용자 질문과 가장 유사한 문서를 검색하는 과정
    return vectorstore.as_retriever(search_kwargs={"k":k})