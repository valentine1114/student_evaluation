import axios from 'axios';

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchYearlySummary = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlySummary`);
  console.log(response.data);
  return response.data;
};
export const submitYearlySummaryScore = async (summary_score) => {
  const data = {
    summary_score
  }
  return request({
    url: `${API_BASE_URL}/yearlySummaryScore`,
    method: 'post',
    data: data

  },
    console.log(this.request.data))
};