import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { QueryClientProvider } from '@tanstack/react-query'
import { QueryConfig } from './config/QueryConfig.js'

import './index.css'
import App from './App.jsx'
import RouterTest from './pages/02_RouterTest.jsx'
import NewVariable from './components/01_NewVariable.jsx'
import Query from './pages/03_Query.jsx'
import Extension from './pages/05_Extension.jsx'
import{
  createBrowserRouter,
  RouterProvider
} from "react-router-dom"
import Path from './pages/04_Path.jsx'
import Props from './pages/06_Props.jsx'
import Rendering from './pages/07_Rendering.jsx'
import ListRendering from './pages/08_ListRendering.jsx'
import EventHandler from './pages/09_EventHandler.jsx'
import ProfilePage from './pages/training/Q1_ProfilePage.jsx'
import ButtonPage from './pages/training/Q2_ButtonPage.jsx'
import LoginPage from './pages/training/Q3_LoginPage.jsx'
import FruitPage from './pages/training/Q4_FruitPage.jsx'
import EvenPage from './pages/training/Q5_EvenPage.jsx'
import MenuPage from './pages/training/Q6_MenuPage.jsx'
import MessagePage from './pages/training/Q7_MessagePage.jsx'
import State from './pages/10_State.jsx'
import UseState from './pages/11_useState.jsx'
import FormHandling from './pages/12_FormHandling.jsx'
import Lifting from './pages/13_Lifting.jsx'
import Counter from './pages/14_Counter.jsx'
import ThemeToggle from './pages/15_ThemeToggle.jsx'
import NameInput from './pages/16_NameInput.jsx'
import OtherPage from './pages/17_OtherPage.jsx'
import VisitCount from './pages/17_VisitCount.jsx'
import Toast from './pages/18_Toast.jsx'
import Gugudan from './pages/training/Q10_Gugudan.jsx'
import Dropdown  from './pages/19_Dropdown.jsx'
import NumberList from './pages/20_NumberList.jsx'
import GetUsers from './pages/21_GetUsers.jsx'
import GetUsers2 from './pages/22_GetUsers2.jsx'


const router = createBrowserRouter([
  {
    path: "/01", // URL
    element: <NewVariable /> // 해당 URL로 요청이 왓을 때 보여줄 (렌더링 할)함수
  },
  {
    path: "/02",
    element: <RouterTest />
  },
  {
    path: "/03",
    element: <Query />
  },
  {
    path:"/04/:value",
    element: <Path />
  },
  {
    path: "/05",
    element: <Extension />
  },
  {
    path: "/06",
    element: <Props />
  },
  {
  path: "/07",
  element: <Rendering /> 
  },
  {
  path: "/08",
  element: <ListRendering />
  },
  {
    path: "/09",
    element: <EventHandler />
  },
  {
    path:"/Q1",
    element: <ProfilePage />
  },
  {
    path:"/Q2",
    element: <ButtonPage />
  },
  {
    path:"/Q3",
    element: <LoginPage />
  },
  {
    path:"/Q4",
    element: <FruitPage />
  },
  {
    path:"/Q5",
    element: <EvenPage />
  },
  {
    path:"/Q6",
    element: <MenuPage />
  },
  {
    path:"/Q7",
    element: <MessagePage />
  },
  {
    path:"/10",
    element: <State />
  },
  {
    path:"/11",
    element: <UseState />
  },
  {
    path:"/12",
    element: <FormHandling />
  },
  {
    path:"/13",
    element: <Lifting />
  },
  {
    path:"/14",
    element: <Counter />
  },
  {
    path:"/15",
    element: <ThemeToggle />
  },
    {
    path:"/16",
    element: <NameInput />
  },
      {
    path:"/17",
    element: <VisitCount />
  },
  {
    path:"/17_Other",
    element: <OtherPage />
  },
  {
    path:"/18",
    element: <Toast />
  },
  {
  path:"/Q10",
  element: <Gugudan />
  },
  {
  path:"/19",
  element: <Dropdown />
  },
  {
  path:"/20",
  element: <NumberList />
  },
  {
  path:"/21",
  element: <GetUsers />
  },
  {
  path:"/22",
  element: <GetUsers2 />
  }
])


createRoot(document.getElementById('root')).render(
  <StrictMode>

    <QueryClientProvider client={QueryConfig}>   
    <RouterProvider router={router}/>
    </QueryClientProvider>

  </StrictMode>,
)






