import axios from 'axios';

const API_BASE_URL = 'http://127.0.0.1:8818';

export const fetchYearlySummary = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlySummary`);
  console.log(response.data);
  return response.data;
};
export const submitYearlySummary = async (yearlySummary, id) => {

  try {
    const response = await axios.get(`${API_BASE_URL}/api/yearlySummary`);

    console.log(response.data);
    console.log(id)
    const dataList = response.data.filter((item) => item.student. === +id);

    console.log(dataList)
    dataList[0].summary = yearlySummary;
    const res = await axios.post(`${API_BASE_URL}/yearlySummary`, dataList[0]);
    console.log(res.data);
    return response.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};
