import useThemeStore from "../store/15_ThemeStore"

export default function ThemeToggle(){
    const {isDark, toggleTheme} = useThemeStore();

    return(
        <div style={{background: isDark ? '#222' : '#fff', color: isDark ? '#fff' : '#222'}}>
            <p>{isDark ? '다크 모드' : '라이트모드'}</p>
            <button onClick={toggleTheme}>모드 전환</button>
        </div>
    
    )
}