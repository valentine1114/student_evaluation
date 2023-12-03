import axios from 'axios';
import request from '@/utils/request'

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchStudentVolunteer = async (id) => {



  const response = await axios.get(`${API_BASE_URL}/studentVolunteer`);

  console.log(response.data);
  console.log(id)
  const dataList = response.data.filter((item) => item.id === +id);

  console.log(dataList)
  return dataList;

};
export const teacherGetStudentVolunteer = async () => {



  const response = await axios.get(`${API_BASE_URL}/studentVolunteer`);

  return response.data;

};