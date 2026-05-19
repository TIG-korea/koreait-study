import { useState } from 'react';
import { useMutation } from '@tanstack/react-query';
import { fetchPrediction } from '../api/modelApi';
import { useStore } from '../store/useStore';
import './PredictPage.css'; // CSS 파일 임포트
import ReactMarkdown from "react-markdown";
import remarkGfm from "remark-gfm";

export default function PredictPage() {
  const [text, setText] = useState('');
  const { history, addHistory } = useStore();

  const mutation = useMutation({
    mutationFn: fetchPrediction,
    onSuccess: (data) => {
      addHistory({ text, result: data, time: new Date().toLocaleTimeString() });
    },
    onError: (error) => {
      alert("서버 연결 실패: " + error.message);
    }
  });

  const handleSubmit = () => {
    if (!text.trim()) return;
    mutation.mutate(text);
  };

  return (
    <div className="predict-container">
      <header className="title-section">
        <h1>AI Inference Hub</h1>
        <p>FastAPI 백엔드로 텍스트 분석 요청을 보냅니다.</p>
      </header>

      <main className="card">
        <textarea
          className="input-area"
          value={text}
          onChange={(e) => setText(e.target.value)}
          placeholder="모델에게 보낼 문장을 입력하세요..."
        />

        <button
          onClick={handleSubmit}
          disabled={mutation.isPending || !text}
          className="submit-btn"
        >
          {mutation.isPending ? '분석 중...' : '분석 결과 요청'}
        </button>

        {mutation.isPending && (
          <div className="result-section">
            <span className="status-badge loading">모델이 생각 중입니다...</span>
          </div>
        )}

        {mutation.isSuccess && (
          <div className="result-section">
            <div className="result-header">
              <span className="status-badge success">✔ 분석 완료</span>
            </div>

            <div className="ai-response">
              <h3>AI 응답</h3>
              <div className="ai-content">
                <ReactMarkdown remarkPlugins={[remarkGfm]}>
                  {mutation.data?.result || ""}
                </ReactMarkdown>
              </div>
            </div>

            <details className="debug-section">
              <summary>원본 데이터 보기</summary>
              <pre>
                {JSON.stringify(mutation.data, null, 2)}
              </pre>
            </details>
          </div>
        )}
      </main>

      {history.length > 0 && (
        <section className="history-list">
          <h3>최근 작업 내역</h3>
          {history.map((item, idx) => (
            <div key={idx} className="history-item">
              <strong>[{item.time}]</strong> {item.text.substring(0, 30)}...
            </div>
          ))}
        </section>
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
    </div>
  );
}

