import axios from 'axios';

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const submitVolunteerSummaryScore = async (volunteer_score, data) => {

  try {
    const res = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores`);
    console.log(res.data);
    console.log(data)
    const dataList = res.data.filter((item) => item.id === data.id);
    console.log(dataList);
    dataList[0].volunteerScore = volunteer_score;
    const response = await axios.post(`${API_BASE_URL}/yearlyGpaSummaryScores/volunteer`, dataList[0]);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};