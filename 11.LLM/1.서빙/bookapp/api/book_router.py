from fastapi import APIRouter
from bookapp.schemas.book_schemas import BookRequest, BookResponse
from bookapp.service.book_service import generate_booktext

router = APIRouter(prefix="/api/books", tags=["books"])

@router.post("/generate", response_model=BookResponse)
def generate(data: BookRequest):
    return generate_booktext(data)