import axios from 'axios';

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchStudentScoresList = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores`);
  console.log(response.data);
  return response.data;
};
export const submitSocialScore = async (summary_score, data) => {

  try {
    const res = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores`);
    console.log(res.data);
    console.log(data);
    const dataList = res.data.filter((item) => item.student.id === data);
    console.log(dataList);
    dataList[0].socialPracticeScore = summary_score;
    const response = await axios.post(`${API_BASE_URL}/yearlyGpaSummaryScores/social`, dataList[0]);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};
