import axios from 'axios';

const API_BASE_URL = 'http://127.0.0.1:8818/api';

export const fetchStudentScoresList = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores`);
  console.log(response.data);
  return response.data;
};

export const fetchGpaScoresList = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores/GPA`);
  console.log(response.data);
  return response.data;
};

export const fetchResearchScoresList = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores/research`);
  console.log(response.data);
  return response.data;
};

export const fetchVolunteerScoresList = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores/volunteer`);
  console.log(response.data);
  return response.data;
};

export const fetchSocialScoresList = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores/social`);
  console.log(response.data);
  return response.data;
};

export const fetchLeadershipScoresList = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores/leadership`);
  console.log(response.data);
  return response.data;
};

export const fetchYearlyScoresList = async () => {
  const response = await axios.get(`${API_BASE_URL}/yearlyGpaSummaryScores/yearly`);
  console.log(response.data);
  return response.data;
};