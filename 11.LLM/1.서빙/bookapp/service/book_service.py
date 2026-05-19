from bookapp.schemas.book_schemas import BookRequest,BookResponse

def generate_booktext(data: BookRequest) -> BookResponse:
    if data.genre == "소설" and data.purpose == "힐링/위로":
        return BookResponse(
            result= "힐링과 위로를 원하는 독자에게 부담 없이 읽히는 소설"
        )
    return  BookResponse(
        result= "asdasdasd"
    )