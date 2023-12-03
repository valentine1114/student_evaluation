import axios from 'axios';
import request from '@/utils/request'

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchStudentScores = async (id) => {



  const response = await axios.get(`${API_BASE_URL}/studentScores`);
  console.log(response.data);
  return response.data[id];
};