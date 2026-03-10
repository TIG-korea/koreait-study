import GuguNumberStore from "../../store/Q10_GugudanStore";

export default function Gugudan(){
    
    const {number1, number2 ,setNumber1, setNumber2, message, showMessage, clearMessage,answer,setAnswer}= GuguNumberStore();

    const handleCheck = () => {
        const realresult = Number(number1) * Number(number2);

        if(Number(answer) === realresult ){
            showMessage('정답입니다')
        } else if( Number(answer) !== realresult){showMessage('오답입니다')

        } else if (answer !== ''){
            showMessage('')
        }
            
    }

    const handleReset= () => {
        setAnswer("");
        clearMessage();
        setNumber1("");
        setNumber2("");
    }

    return(
        <>
            <div>
                <label htmlFor="number1">첫번째 수 (a):</label>
                <input type="number" id="number1" value={number1} onChange={(e) => setNumber1(e.target.value)} />
            </div>
            <div>
                <label htmlFor="number2">두번째 수 (b):</label>
                <input type="number" id="number2" value={number2} onChange={(e) => setNumber2(e.target.value)}/>
            </div>
            <p >
                {/* 문제 : a x b = ? 형식으로 보여야 함 */}
                문제: {number1} x {number2} = ?
            </p>
            <input type="number" 
            value = {answer}
            onChange={(e) => setAnswer(e.target.value)}
            />
            <button onClick={handleCheck}>정답 확인</button>
            <button style={{marginLeft: '10px'} } onClick={handleReset}>초기화</button>

            {/* 
                사용자가 입력한 숫자가 정답일 경우 '정답 입니다!' 출력
                정답이 아닐 경우 '오답 입니다!' 출력
            */}
            {message &&
            <p style={{marginTop: '10px'}}>{message}</p>
            }
                
        </>
    )
}