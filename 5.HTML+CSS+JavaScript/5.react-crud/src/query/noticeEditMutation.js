import { useMutation , useQueryClient} from "@tanstack/react-query"
import { noticeEditApi } from "../api/boardApi";



export const useNoticeEditMutation = () => {
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: (postId, formData) => noticeEditApi(postId, formData),

        onSuccess: () =>{
            queryClient.invalidateQueries({
                queryKey: ['noticeDetail', variables.postId] 
            });

            // 리스트 페이지 갱신 
            queryClient.invalidateQueries({
                queryKey: ['noticeList']
            });

        },
        onError: (error) => {
            console.error(error);
            alert("게시글을 수정할 수 없습니다.");
        }





    })
}