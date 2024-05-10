import { useState } from 'react';

const Counter = () => {
  const [count, setCount] = useState(0); // useState(initialState)

  console.log('Counter component is rendered at', new Date());
  const decrement = () => {
    setCount(count - 1);
  };

  const increment = () => {
    setCount(count + 1);
  };

  return (
    <>
      <h3>Counter app</h3>
      <p className='lead'>demonstrates the use of `state` in a react app</p>
      <button onClick={decrement} className='btn btn-primary'>
        Decrement
      </button>
      <span className='ms-5 me-5 app-count text-center'>{count}</span>
      <button onClick={increment} className='btn btn-primary'>
        Increment
      </button>
    </>
  );
};

export default Counter;
