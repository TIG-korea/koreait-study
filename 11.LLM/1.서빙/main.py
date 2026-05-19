from fastapi import FastAPI
from bookapp.api import book_router
from fastapi.middleware.cors import CORSMiddleware
from app.api import gpt_router

app = FastAPI(
    # title="FastAPI GPT 서비스",
    # version="1.0.0"
)


# CORS 허용 설정
origins = [
    "http://localhost:5173",
    "http://127.0.0.1:5173",
]


app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

app.include_router(book_router.router)
app.include_router(gpt_router.router)

@app.get("/")
def read_root():
    return {"message": "TEST"}