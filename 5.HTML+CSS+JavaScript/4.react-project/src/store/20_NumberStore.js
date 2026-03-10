import { create } from "zustand";


const useNumberStore = create((set) => ({

    numbers: [],
    addNumber: (num) => set((state) => ({numbers: [...state.numbers, num] })),
    removeNumber:(removeIndedx) => set((state) => ({ 
        numbers: state.numbers.filter((_, index) => index !== removeIndedx)
    }))

})) 

export default useNumberStore;