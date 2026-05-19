from pydantic import BaseModel

class BookRequest(BaseModel):
    description: str
    genre: str
    level: str
    purpose: str
    # max_completion_tokens: int = 20000
    # temperature: float = 0.5

class BookResponse(BaseModel):
    result: str