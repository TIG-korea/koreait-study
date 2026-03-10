import { create } from "zustand";


const GuguNumberStore =create((set) => ({
    number1: "",
    number2: "",
    message: "",
    answer: "",
    setAnswer: (result) => set({answer : result}),
    showMessage: (msg) => set({message: msg}),
    clearMessage: () => set ({message: ''}),
    setNumber1:(newNumber1) => set({number1:newNumber1}),
    setNumber2:(newNumber2) => set({number2:newNumber2}),
    
}))


export default GuguNumberStore;