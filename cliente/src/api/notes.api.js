import axios from 'axios'

export const getAllNotes = () => {
    return axios.get('http://localhost:8080/notes')
}