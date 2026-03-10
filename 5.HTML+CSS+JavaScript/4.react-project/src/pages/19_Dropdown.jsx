import DropDownStore from "../store/19_DropdownStore";

export default function Dropdown (){
    
    const {selectOption, setSelectOption} = DropDownStore();

    return(
        <>
            <h2>드랍다운 선택</h2>
            <select name="" id="">
                <option value="" onChange={(e) => setSelectOption(e.target.value)}>선택하세요</option>
                <option value="apple">사과</option>
                <option value="banana">바나나</option>
                <option value="orange">오렌지</option>
            </select>
            <p>선택된 값 :{selectOption}</p>
        </>
    )
}