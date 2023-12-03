import axios from 'axios';

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchStudentScoresList = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores`);
  console.log(response.data);
  return response.data;
};