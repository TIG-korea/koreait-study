from langchain_community.document_loaders import TextLoader

# data/sample.txt 파일을 읽어서 document 리스트로 변환
#   - document list : 랭체인에서 사용하는 문서들의 리스트
def load_document(path:str):
    loader = TextLoader(path, encoding="utf-8")
    return loader.load()