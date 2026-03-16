import axios from "axios";

// 다음 API를 호출하는 함수를 작성하세요.
//  - 함수명 : getUsers
//  - async/await을 사용한 비동기 함수
//  - 매개변수 받지 않음
//  - axios.get(URL)과 같이 API를 호출한 후 응답 결과를 반환합니다.
//  - API URL : https://jsonplaceholder.typicode.com/users


const axiosInstance =axios.create({
    baseURL:'http://localhost:5173/',
    timeoutL: 10000,
    headers:{
        'Content-Type' : 'application/json'
    }
})

export default axiosInstance;



export const getUsers = async () => {
    try{
        const response = await axiosInstance.get("https://jsonplaceholder.typicode.com/users")
        return response.data;
    }catch(err){
        console.log("통신실패 : ", err);
    }
}
