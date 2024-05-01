import React, { useState } from 'react';

const initialState = [
  'Vinod Kumar',
  'Shyam Sundar',
  'Naveen',
  'Saju',
  'Harish',
  'Naveen',
];
const NameList = () => {
  const [names, setNames] = useState(initialState);

  const deleteName = (index) => {
    const remainingNames = names.filter((_, idx) => idx !== index);
    setNames(remainingNames); // ask react to update its state
    // the changes will apply only after re-render of the component
  };

  const namesJsx = names.map((name, index) => (
    <li className='list-group-item lead app-person-name' key={index}>
      {name}
      <button
        onClick={() => deleteName(index)}
        className='btn btn-link float-end bi bi-trash text-danger'
      ></button>
    </li>
  ));

  return (
    <>
      <h3>Names list</h3>
      <ul style={{ width: '400px' }} className='list-group'>
        {namesJsx}
      </ul>
    </>
  );
};

export default NameList;
