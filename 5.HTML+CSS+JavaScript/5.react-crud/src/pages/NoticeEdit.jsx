import Header from "../components/Header";
import { useNoticeEditHook } from "../hooks/useNoticeEditHook";


export default function NoticeEdit() {
    const { data,
        postId,
        error,
        isError,
        editForm,
        handleChange,
        isLoading,
        quillRef
    } = useNoticeEditHook();

    if (isLoading) {
        return(
            <>
            <Header />
            <div className="container">
                <div style={{ textAlign: 'center' }}>로딩중</div>
            </div>
        </>
        )
    }

    if (isError) {
        return(
            <>
            <Header />
            <div className="container">
                <div style={{ textAlign: 'center' }}>알 수 없는 오류가 발생했습니다.</div>
            </div>
        </>
        )
    }

    if (!data) {
        return(
            <>
            <Header />
            <div className="container">
                <div style={{ textAlign: 'center' }}>게시글을 수정 할 수 없습니다.</div>
            </div>
        </>
        )
    }

    // [핵심] 수정 처리 함수
    const handleUpdate = (e) => {
        e.preventDefault(); // 페이지 새로고침 방지

        // 1. 에디터에서 현재 작성된 HTML 내용을 가져옵니다.
        const editorContent = quillRef.current ? quillRef.current.root.innerHTML : "";

        // 2. 서버로 보낼 데이터를 구성합니다.
        const updatedData = {
            ...editForm,
            content: editorContent // 폼 상태의 content 대신 에디터의 실제 HTML을 담습니다.
        };

        // 3. 이제 여기서 서버 수정 API(Mutation)를 호출하세요!
        console.log("서버로 전송할 데이터:", updatedData);
        // 예: editMutation.mutate(updatedData);
    };


    return (
        <>
            <Header />

            <div className="container">
                <h1 style={{ marginBottom: "2rem" }}>공지사항 수정</h1>
                <div className="form-card" style={{ maxWidth: 800 }}>
                    <form onsubmit={handleUpdate}>
                        <div className="form-group">
                            <label>분류</label>
                            <select
                                name="category" // 
                                value={editForm.category} //
                                onChange={handleChange} //
                                style={{
                                    width: "100%",
                                    padding: "0.75rem",
                                    border: "1px solid var(--border)",
                                    borderRadius: "0.5rem"
                                }}
                            >
                                <option value="공지">공지</option>
                                <option value="점검">점검</option>
                                <option value="이벤트">이벤트</option>
                            </select>
                        </div>
                        <div className="form-group">
                            <label>제목</label>
                            <input
                                type="text"  ///////////
                                name="title"
                                value={editForm.title}
                                onChange={handleChange}
                                placeholder="공지사항 제목을 입력하세요"
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label>내용</label>
                            <div id="noticeEditor"
                            className="editor-container" />
                        </div>
                        <div className="form-group">
                            <label>이미지 업로드</label>
                            <input type="file" id="announcementImage" accept="image/*" />
                            <div id="imagePreview" style={{ marginTop: "1rem" }} />
                        </div>
                        <div className="form-actions" style={{ textAlign: "center" }}>
                            <button type="submit" className="btn btn-primary">
                                수정
                            </button>
                            <button
                                type="button"
                                className="btn btn-secondary"
                                onClick={() => navigate(`/notice/detail/${id}`)}
                            >
                                취소
                            </button>
                        </div>
                    </form>
                </div>
            </div>


        </>

    )

}