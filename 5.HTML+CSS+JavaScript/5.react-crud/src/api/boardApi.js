import axiosInstance from "./AxiosInstance"

// 공지사항 목록 조회
export const noticeListApi = async (page = 1) => {
    const response = await axiosInstance.get("/api/board/notice", {
        params: {
            page: page,
        },
        withCredentials: true
    })
    return response.data;
}


// 공지사항 상세보기 조회
export const NoticeDetailApi = async (postId) => {
    try{
        const response = await axiosInstance.get(`/api/board/notice/${postId}`,{
            withCredentials: true
        })

        return response.data;
    } catch(err){

        // 서버가 응답을 햇는데 상태 코드가 4xx, 5xx
        if(err.response){
            console.error('응답 데이터:' , err.response.data);
            throw err;
        } else if(err.request){
            // 요청은 보냈는데 서버가 응답을 하지 않앗을 떄
            console.error('서버에 연결할 수 없습니다.')
            throw err;
        } else {
            // 요청 중 에러 발생했을 떄
            console.error('요청 중 에러 발생 : ', err.message);
            throw err;
        }

    }
}

// 공지사항 삭제
export const noticeDeleteApi = async (postId) =>{
    const response = await axiosInstance.delete(`/api/board/notice/${postId}`,{
        withCredentials: true
    });

    return response.data;



    // try{

    // }catch(err){
    //     if(err.response){
    //         console.log('응답 데이터: ', err.message);
    //         throw err;
    //     }
    // }
}


export const noticeCreateApi = async (formData) => {
    const response = await axiosInstance.post("/api/board/notice",
                                                formData,{
                                                    withCredentials : true,
                                                    headers: {
                                                        "Content-Type": "multipart/form-data"
                                                    }

                                                }
    )
    return response.data;
}


export const noticeEditApi = async(postId, formData) =>{
    const response = await axiosInstance.post(`/api/board/notice/${postId}/edit`, formData, {
        withCredentials: true,
        headers: {
            "Content-Type": "multipart/form-data"
        }
    });
    return response.data;
}

