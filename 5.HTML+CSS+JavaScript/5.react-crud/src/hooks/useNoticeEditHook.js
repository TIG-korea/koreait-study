import { useNavigate, useParams } from "react-router-dom"
import { useNoticeDetailQuery } from "../query/NoticeDetailQuery";
import { useState, useEffect } from "react";
import { useQuillEditorHook } from "./useQuillEditorHook";

export const useNoticeEditHook = () => {
    const { id } = useParams();
    const navigate =useNavigate();
    const postId =id ? parseInt(id) : null;

    const {data, isLoading, isError, error} = useNoticeDetailQuery(postId);

    const [editForm, setEditForm] = useState ({
        category : "",
        title: "",
        content: ""
    });

    const { quillRef, editorReady} =useQuillEditorHook();

    useEffect(() => {
        if (data){
            setEditForm({
                category: data.category,
                title: data.title,
                content: data.content
            });
        }
    }, [data]); // 데이터가 바뀔 때마다 실행이 됨


    useEffect(() =>{
        if (data && editorReady && quillRef.current) {
            quillRef.current.clipboard.dangerouslyPasteHTML(data.content || "");
        }
    },[data, editorReady]);






    const handleChange = (e) => {
        const { name, value } = e.target;
        setEditForm((prev) => ({ ...prev, [name]: value }));
    };

    return {data,
            postId,
            error,
            isError,
            editForm, 
            handleChange, 
            isLoading
            };
}