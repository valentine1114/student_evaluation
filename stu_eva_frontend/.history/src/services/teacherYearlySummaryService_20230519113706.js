import axios from 'axios';

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchYearlySummary = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlySummary`);
  console.log(response.data);
  return response.data;
};
export const submitYearlySummaryScore = async (summary_score, msg) => {
  const res = await axios.get(`${API_BASE_URL}/yearlySummaryScores`);
  this.dataList = this.res.filter((item) => item.id === msg);
  console.log(dataList)
  dataList[0].summaryScore = summary_score
  // res.data[0].summaryScore
  //   = summary_score


  try {

    const response = await axios.post(`${API_BASE_URL}/yearlySummaryScores`, dataList[0]);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};