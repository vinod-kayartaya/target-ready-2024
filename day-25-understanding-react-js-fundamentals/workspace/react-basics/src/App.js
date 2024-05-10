import Header from './components/Header';
import Footer from './components/Footer';
import './App.css';

// component using a function;
// function name must begin with capital letter
function App() {
  // must return a JSX
  return (
    <div>
      <Header />
      <div className='container app-main-container'>
        <p>React is cool</p>
      </div>
      <Footer />
    </div>
  );
}

export default App;
