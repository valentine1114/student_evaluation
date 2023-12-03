import axios from 'axios';

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchYearlySummary = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlySummary`);
  console.log(response.data);
  return response.data;
};
export const submitYearlySummaryScore = async (summary_score) => {
  const data = {
    summary_score: summary_score
  };

  try {
    const response = await axios.post(`${API_BASE_URL}/yearlySummaryScores`, data);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};