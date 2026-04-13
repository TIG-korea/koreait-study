from http.client import responses
from fastapi import  APIRouter
from app.schemas.gpt_schema import GPTRequest, GPTResponse
from app.service.gpt_service import GPTService

router = APIRouter(prefix="/gpt", tags=["gpt"])

servcie = GPTService()

@router.post("/generate", response_model=GPTResponse)
def generate_text(req: GPTRequest):

    result = servcie.generate_text(
        prompt = req.prompt,
        max_completion_tokens = req.max_completion_tokens,
        temperature = req.temperature
    )

    return GPTResponse(result=result)