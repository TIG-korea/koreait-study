# uvicorn app.main:app --reload


from langchain_openai import ChatOpenAI
from app.core.config import settings

def get_llm():
    return ChatOpenAI(
        api_key=settings.OPENAI_API_KEY,
        model="gpt-5.4-mini",
        temperature=0.4
    )