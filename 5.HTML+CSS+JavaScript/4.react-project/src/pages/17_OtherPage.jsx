import useVisitCountStore from "../store/17_VisitCountStore.js"
import { Link } from "react-router-dom";

export default function OtherPage(){
    const { visitCount } = useVisitCountStore();

    return(
        <>
            <h2>다른 페이지</h2>
            <p>현재 visit 페이지에 방문한 횟수는 <strong>{visitCount}</strong>번 입니다.</p>
            <Link to="/17">방문 페이지로 이동하기</Link>   
        </>
    )
}