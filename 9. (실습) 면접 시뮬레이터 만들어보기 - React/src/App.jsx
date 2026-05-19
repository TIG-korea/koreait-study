import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PredictPage from './pages/PredictPage_2';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<PredictPage />} />
      </Routes>
    </Router>
  );
}
export default App;


