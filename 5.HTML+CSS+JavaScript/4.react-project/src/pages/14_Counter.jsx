import useCounterStore from "../store/14_CounterStore"

export default function Counter (){
    const {count,increase} = useCounterStore(); 
    // const count = useCounterStore((state) => state.count)
    // const increase = useCounterStore((state) => state.increase)
    


    return(
        <>
            <p>{count}</p>
            <button onClick={increase}></button>

        </>
    )
} 