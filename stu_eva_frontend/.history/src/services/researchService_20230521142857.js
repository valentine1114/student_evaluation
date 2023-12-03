import axios from 'axios';

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchResearch = async () => {
  const response = await axios.get(`${API_BASE_URL}/research`);
  console.log(response.data);
  return response.data;
};
export const studentSubmitResearch = async (dataList,) => {

  try {
    // const response = await axios.get(`${API_BASE_URL}/research`);

    // console.log(response.data);
    console.log(id)
    // const dataList = response.data.filter((item) => item.id === +id);

    console.log(dataList)
    dataList[0].summary = yearlySummary;
    const res = await axios.post(`${API_BASE_URL}/research`, dataList[0]);
    console.log(res.data);
    return res.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};
export const teacherSubmitResearchScore = async (research_score, data) => {

  try {
    const res = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores`);
    console.log(res.data);
    console.log(data)
    const dataList = res.data.filter((item) => item.id === data.id);
    console.log(dataList);
    dataList[0].researchScore = research_score;
    const response = await axios.post(`${API_BASE_URL}/yearlyGpaSummaryScores/research`, dataList[0]);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};
