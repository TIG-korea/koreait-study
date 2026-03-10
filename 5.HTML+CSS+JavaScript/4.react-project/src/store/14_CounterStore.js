import { create }  from "zustand";


const useCounterStore = create((set) => ({
    count : 0,
    increase: () => set((state) => ({count: state.count+1}))
    // setCount((count) => count+1) 같음
}))

export default useCounterStore;