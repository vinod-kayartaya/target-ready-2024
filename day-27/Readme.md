# React.js Routing and Hooks

## Introduction to React Router for handling client-side routing

React Router is a popular library used for handling client-side routing in React.js applications. It allows developers to define routes and navigate between different views or pages within a single-page application (SPA) without a page reload. React Router provides a declarative way to define routes and integrates seamlessly with React components.

### Key Concepts of React Router:

1. **Route**: Routes are used to define mappings between URLs and React components. Each route specifies a URL path and the corresponding component to render when the URL matches the path.

2. **Router**: The Router component is the root component of a React Router application. It provides context to all the route components nested within it and manages the routing logic.

3. **Link**: The Link component is used to create hyperlinks within the application. It allows users to navigate between different views without a full page reload, preserving the SPA behavior.

4. **Switch**: The Switch component is used to render the first child Route or Redirect that matches the current URL. It ensures that only one route is rendered at a time.

### Installation:

To use React Router in your project, you need to install the `react-router-dom` package from npm.

```bash
npm install react-router-dom
```

### Basic Usage:

Here's a simple example demonstrating how to set up React Router in a React.js application:

```jsx
import React from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

const Home = () => <h2>Home</h2>;
const About = () => <h2>About</h2>;

const App = () => {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to='/'>Home</Link>
            </li>
            <li>
              <Link to='/about'>About</Link>
            </li>
          </ul>
        </nav>

        <Route path='/' exact component={Home} />
        <Route path='/about' component={About} />
      </div>
    </Router>
  );
};

export default App;
```

In the above example:

- The `Router` component wraps the entire application and provides routing context.
- The `Link` components are used to create navigation links.
- The `Route` components define mappings between URL paths and React components.
- When a user clicks on a link, the corresponding component specified in the `Route` is rendered in place of the current content.

### Nested Routes:

React Router also supports nested routes, allowing you to define routes within routes to create more complex navigation structures.

### Additional Features:

React Router provides additional features such as:

- **Route Parameters**: Dynamically match and extract parameters from URL paths.
- **Programmatic Navigation**: Navigate programmatically using the `history` object or higher-order components like `withRouter`.
- **Route Guards**: Protect routes by implementing route guards to control access based on certain conditions.

React Router is a powerful library for handling client-side routing in React.js applications. It simplifies the process of creating SPAs by providing a declarative way to define routes and navigate between different views. Whether you're building a simple application with a few routes or a complex SPA with nested routes, React Router offers the flexibility and features you need to manage client-side routing effectively.

## Configuring routes in a React.js application

Configuring routes in a React.js application involves setting up the routing logic to define mappings between URLs and React components. This allows users to navigate between different views or pages within a single-page application (SPA) without a full page reload. React Router is the most commonly used library for handling client-side routing in React applications.

Here's a step-by-step guide on how to configure routes in a React.js application using React Router:

### 1. Install React Router:

First, you need to install React Router in your project using npm or yarn.

```bash
npm install react-router-dom
```

### 2. Set Up Routes:

Define the routes in your application by wrapping your root component with the `BrowserRouter` component and specifying route mappings using the `Route` component.

```jsx
// App.js
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import NotFound from './components/NotFound';

const App = () => {
  return (
    <Router>
      <div>
        <Switch>
          <Route path='/' exact component={Home} />
          <Route path='/about' component={About} />
          <Route component={NotFound} />
        </Switch>
      </div>
    </Router>
  );
};

export default App;
```

### 3. Create Component Views:

Create the React components that correspond to the routes defined in your application. These components will be rendered when the corresponding URLs are matched.

```jsx
// components/Home.js
import React from 'react';

const Home = () => {
  return <h2>Home Page</h2>;
};

export default Home;
```

```jsx
// components/About.js
import React from 'react';

const About = () => {
  return <h2>About Page</h2>;
};

export default About;
```

```jsx
// components/NotFound.js
import React from 'react';

const NotFound = () => {
  return <h2>404 - Page Not Found</h2>;
};

export default NotFound;
```

### 4. Create Navigation Links:

Create navigation links using the `Link` component provided by React Router. These links will allow users to navigate between different views within your application.

```jsx
// components/Header.js
import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <nav>
      <ul>
        <li>
          <Link to='/'>Home</Link>
        </li>
        <li>
          <Link to='/about'>About</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Header;
```

### 5. Handle Route Parameters:

You can also handle dynamic route parameters by specifying route paths with placeholders using the `:param` syntax.

```jsx
<Route path='/user/:userId' component={User} />
```

You can then access these parameters using the `useParams` hook or `props.match.params` in your component.

Configuring routes in a React.js application involves setting up the routing logic using React Router, creating the necessary components for each route, and creating navigation links to allow users to navigate between different views. With React Router, you can create a powerful SPA with a clean and intuitive routing system.

## Implementing navigation in React.js using Link and NavLink components

Implementing navigation in React.js can be achieved using the `Link` and `NavLink` components provided by React Router. These components allow you to create navigation links that enable users to navigate between different views or pages within a single-page application (SPA) without a full page reload.

### Using Link Component:

The `Link` component is used to create navigation links in React Router. It provides a declarative way to navigate to different routes within your application without reloading the entire page.

```jsx
import React from 'react';
import { Link } from 'react-router-dom';

const Navigation = () => {
  return (
    <nav>
      <ul>
        <li>
          <Link to='/'>Home</Link>
        </li>
        <li>
          <Link to='/about'>About</Link>
        </li>
        <li>
          <Link to='/contact'>Contact</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navigation;
```

In the above example, the `Link` component is used to create navigation links for the Home, About, and Contact pages. When a user clicks on a link, React Router will render the corresponding component without reloading the entire page.

### Using NavLink Component:

The `NavLink` component is a special version of the `Link` component that provides additional styling and behavior for navigation links. It allows you to apply CSS classes to active links, making it easier to style the navigation menu based on the current route.

```jsx
import React from 'react';
import { NavLink } from 'react-router-dom';

const Navigation = () => {
  return (
    <nav>
      <ul>
        <li>
          <NavLink to='/' exact activeClassName='active'>
            Home
          </NavLink>
        </li>
        <li>
          <NavLink to='/about' activeClassName='active'>
            About
          </NavLink>
        </li>
        <li>
          <NavLink to='/contact' activeClassName='active'>
            Contact
          </NavLink>
        </li>
      </ul>
    </nav>
  );
};

export default Navigation;
```

In the above example, the `NavLink` component is used instead of the `Link` component. It adds an `activeClassName` prop, which allows you to specify the CSS class to apply to the active link. The `exact` prop is used to ensure that the active class is only applied when the current route matches exactly.

### Styling Active Links:

You can style active links using CSS to provide visual feedback to users about their current location within the application.

```css
.active {
  font-weight: bold;
  color: blue;
}
```

Implementing navigation in React.js using the `Link` and `NavLink` components provided by React Router is a simple and effective way to create navigation links within your application. These components allow users to navigate between different views without a full page reload and provide additional styling options for active links. With React Router, you can easily build a powerful SPA with clean and intuitive navigation.

## Implementing custom hooks for reusable logic

Implementing custom hooks in React allows you to encapsulate reusable logic into functions that can be easily shared across different components. Custom hooks enable you to abstract away complex logic and state management, promoting code reuse and maintainability. Here's how you can create custom hooks in React:

### 1. Define Custom Hook:

Create a function that starts with the word "use" to indicate that it's a custom hook. Inside this function, you can use built-in hooks such as `useState`, `useEffect`, or other custom hooks if needed.

```jsx
import { useState, useEffect } from 'react';

const useFetchData = (url) => {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(url);
        if (!response.ok) {
          throw new Error('Failed to fetch data');
        }
        const jsonData = await response.json();
        setData(jsonData);
        setLoading(false);
      } catch (error) {
        setError(error);
        setLoading(false);
      }
    };

    fetchData();
  }, [url]);

  return { data, loading, error };
};

export default useFetchData;
```

In this example, `useFetchData` is a custom hook that fetches data from a specified URL using the `fetch` API. It returns an object containing the fetched data, loading state, and error state.

### 2. Use Custom Hook in Components:

You can now use the custom hook in your components to fetch data and manage the loading and error states.

```jsx
import React from 'react';
import useFetchData from './useFetchData';

const MyComponent = () => {
  const { data, loading, error } = useFetchData('https://api.example.com/data');

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  return (
    <div>
      {data && (
        <ul>
          {data.map((item) => (
            <li key={item.id}>{item.name}</li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default MyComponent;
```

In this example, `MyComponent` uses the `useFetchData` hook to fetch data from the specified URL. It renders a loading message while the data is being fetched and displays an error message if there's an error. Once the data is fetched successfully, it renders the fetched data.

### Benefits of Custom Hooks:

- **Reusability**: Custom hooks encapsulate reusable logic that can be used across multiple components.
- **Abstraction**: Custom hooks abstract away complex logic, making components cleaner and easier to understand.
- **Separation of Concerns**: Custom hooks separate concerns by extracting logic from components into reusable functions.
- **Testing**: Custom hooks can be tested independently, promoting better testability of your application logic.

By creating custom hooks, you can streamline your React components, promote code reuse, and improve the overall maintainability of your codebase. Custom hooks are a powerful feature of React that allows you to build more efficient and scalable applications.
