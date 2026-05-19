import { useState } from "react";
import { useMutation } from "@tanstack/react-query";
import { fetchPrediction } from "../api/modelApi";
import { JUNIOR_QUESTIONS } from "../constants/questions";
import "./PredictPage.css";
import ReactMarkdown from "react-markdown";
import remarkGfm from "remark-gfm";

export default function PredictPage() {

  const [selectedQuestion, setSelectedQuestion] = useState("");
  const [answer, setAnswer] = useState("");

  const mutation = useMutation({
    mutationFn: fetchPrediction,
    onError: (error) => {
      alert("서버 연결 실패: " + error.message);
    }
  });

  const handleSubmit = () => {
    if (!selectedQuestion || !answer.trim()) return;

    mutation.mutate({
      question: selectedQuestion,
      answer
    });
  };

  return (
    <div className="predict-container">

      <header className="title-section">
        <h1>AI 기술 면접 시뮬레이터</h1>
        <p>신입 개발자 질문 TOP 50 기반 실전 면접 평가</p>
      </header>

      <main className="card interview-card">

        {/* 질문 선택 */}
        <div className="form-group">
          <label>면접 질문 선택</label><br></br>
          <select
            value={selectedQuestion}
            onChange={(e) => setSelectedQuestion(e.target.value)}
            className="question-select"
          >
            <option value="">질문을 선택하세요</option>
            {JUNIOR_QUESTIONS.map((q, idx) => (
              <option key={idx} value={q}>
                {q}
              </option>
            ))}
          </select>
        </div>

        {/* 답변 입력 */}
        <div className="form-group">
          <label>지원자 답변</label>
          <textarea
            className="input-area large"
            value={answer}
            onChange={(e) => setAnswer(e.target.value)}
            placeholder="여기에 답변을 작성하세요..."
          />
        </div>

        <button
          onClick={handleSubmit}
          disabled={mutation.isPending}
          className="submit-btn interview-btn"
        >
          {mutation.isPending ? "면접관이 평가 중..." : "면접 평가 요청"}
        </button>

        {mutation.isPending && (
          <div className="result-section">
            <span className="status-badge loading">
              AI 면접관이 답변을 분석 중입니다...
            </span>
          </div>
        )}

        {mutation.isSuccess && (
          <div className="result-section evaluation-box">

            <div className="result-header">
              <span className="status-badge success">
                ✔ 평가 완료
              </span>
            </div>

            <div className="ai-response">
              <h3>면접 평가 결과</h3>
              <div className="ai-content">
                <ReactMarkdown remarkPlugins={[remarkGfm]}>
                  {mutation.data?.result || ""}
                </ReactMarkdown>
              </div>
            </div>

          </div>
        )}
      <button
        onClick={() => {
          fetch("http://localhost:8080/login?userId=test&password=1234", {
            method: "GET",
            credentials: "include"
          })
        }}
        className="submit-btn"
      >
        로그인 요청
      </button>
      </main>

    </div>
    
  );
}
