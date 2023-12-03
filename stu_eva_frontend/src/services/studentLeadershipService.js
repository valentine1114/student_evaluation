import axios from 'axios';
import { async } from 'regenerator-runtime';

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchStudentLeadership = async () => {
  const response = await axios.get(`${API_BASE_URL}/studentLeadership`);
  console.log(response.data);
  return response.data;
};
export const studentSubmitStudentLeadership = async (dataList, data) => {

  try {
    // const response = await axios.get(`${API_BASE_URL}/studentLeadership`);
    // const existingData = response.data;

    // // Find the last ID in the existing data
    // const lastId = existingData.length > 0 ? existingData[existingData.length - 1].id : 0;

    // Assign IDs to the dataList starting from the next ID after the last one
    // let currentId = lastId + 1;
    console.log(dataList)
    console.log(data)
    dataList.forEach((item) => {
      console.log(item)
      //item.currentId = currentId++;
      item.student.id = data.id
      console.log(data.id)
      console.log(item)
      const res = axios.post(`${API_BASE_URL}/studentLeadership`, item);
      console.log(res.data);
    });


    return res.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};
export const teacherSubmitStudentLeadershipScore = async (studentLeadership_score, data) => {

  try {
    const res = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores`);
    console.log(res.data);
    console.log(data)
    const dataList = res.data.filter((item) => item.id === data.id);
    console.log(dataList);
    dataList[0].leadershipScore = studentLeadership_score;
    const response = await axios.post(`${API_BASE_URL}/yearlyGpaSummaryScores/studentLeadership`, dataList[0]);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};
