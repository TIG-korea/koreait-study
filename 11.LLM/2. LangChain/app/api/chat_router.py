from fastapi import  APIRouter, Query
from starlette.responses import StreamingResponse

from app.schemas.chat_schema import ChatResponse, ChatRequest
from app.service.chat_service import ChatService

router = APIRouter()
service = ChatService()

@router.post("/chat", response_model=ChatResponse)
def chat(req: ChatRequest):
    result = service.generate(req.question)
    return ChatResponse(answer=result)


@router.post("/chat-stream")
def chat_stream(question:str = Query(...)):
    return StreamingResponse (
        service.stream(question),
        media_type="text/plain"
    )

@router.get("/rag")
def rag(question:str = Query(...)):
    result = service.generate_rag(question)
    return {"question": question, "answer": result}