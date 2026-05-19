from langchain_text_splitters import RecursiveCharacterTextSplitter

def get_splitter() -> RecursiveCharacterTextSplitter:
    # chunk_size :  청크 하나의 최대 문자 길이
    # - 너무 크면 정확도가 내려가고, 너무 작으면 문맥이 부족해짐
    # chuck_overlap : 청크 사이에 겹치는 문자의 길이
    # - 문장이 잘리며 의미가 끊기는걸 완화시켜주는 역할
    # - 너무 작으면 의미가 이어지지 않고, 너무 크면 토큰을 많이 씀
    return RecursiveCharacterTextSplitter(
        chunk_size=200,
        chunk_overlap=50
    )