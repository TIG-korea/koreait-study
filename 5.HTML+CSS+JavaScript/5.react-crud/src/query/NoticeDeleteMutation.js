
import { noticeDeleteApi } from "../api/boardApi";
import { useMutation, useQueryClient } from "@tanstack/react-query";

export const useNoticeDeleteMutation = () => {
    const queryClient = useQueryClient();


    return useMutation({
        mutationFn: (postId) => noticeDeleteApi(postId),
        onSuccess: () =>{
            //리스트 캐시 무효화
            queryClient.invalidateQueries({
                queryKey:['noticeList']
            })
        },
        onError: (error) => {
            alert("게시글을 삭제 할 수 없습니다.")
        }
        
    })
}