import axios from 'axios';

const api = axios.create({ baseURL: 'http://localhost:8080/ai', withCredentials: true });

export const fetchPrediction = async ({question, answer}) => {
  const { data } = await api.post('/generate', {
    question: question,
    answer: answer
  });
  return data;
};
