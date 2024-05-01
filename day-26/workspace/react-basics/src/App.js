import Header from './components/Header';
import Footer from './components/Footer';
import Counter from './components/Counter';
import NameList from './components/NameList';
import MoviePosters from './components/MoviePosters';
import MovieList from './components/MovieList';

const App = () => {
  return (
    <>
      <Header />
      <div className='container app-main'>
        {/* <Counter />
        <hr />
        <NameList />
        <hr />
        <MoviePosters /> */}
        <MovieList />
      </div>
      <Footer />
    </>
  );
};

export default App;
