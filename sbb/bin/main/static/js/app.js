// 공통 유틸리티 함수
const TaxiShare = {
  // 로컬 스토리지 관리
  storage: {
    set: (key, value) => {
      try {
        localStorage.setItem(key, JSON.stringify(value))
      } catch (e) {
        console.error("Storage error:", e)
      }
    },
    get: (key) => {
      try {
        const item = localStorage.getItem(key)
        return item ? JSON.parse(item) : null
      } catch (e) {
        console.error("Storage error:", e)
        return null
      }
    },
    remove: (key) => {
      localStorage.removeItem(key)
    },
  },

  // 사용자 인증 관리
  auth: {
    isLoggedIn: () => {
      return TaxiShare.storage.get("user") !== null
    },
    login: (email, password) => {
      // 실제로는 서버 API 호출
      const user = {
        name: "김민수",
        email: email,
        rating: 4.9,
        trips: 127,
      }
      TaxiShare.storage.set("user", user)
      return user
    },
    logout: () => {
      TaxiShare.storage.remove("user")
      window.location.href = "index.html"
    },
    getUser: () => {
      return TaxiShare.storage.get("user")
    },
  },

  // 토스트 알림
  toast: {
    show: (message, type = "info") => {
      const toast = document.createElement("div")
      toast.className = `fixed top-4 right-4 px-6 py-3 rounded-lg shadow-lg z-50 ${
        type === "success" ? "bg-green-500" : type === "error" ? "bg-red-500" : "bg-blue-500"
      } text-white`
      toast.textContent = message
      document.body.appendChild(toast)

      setTimeout(() => {
        toast.style.opacity = "0"
        toast.style.transition = "opacity 0.3s"
        setTimeout(() => toast.remove(), 300)
      }, 3000)
    },
  },

  // 날짜 포맷팅
  formatDate: (date) => {
    const d = new Date(date)
    return `${d.getFullYear()}.${String(d.getMonth() + 1).padStart(2, "0")}.${String(d.getDate()).padStart(2, "0")}`
  },

  // 시간 포맷팅
  formatTime: (date) => {
    const d = new Date(date)
    return `${String(d.getHours()).padStart(2, "0")}:${String(d.getMinutes()).padStart(2, "0")}`
  },
}

// 페이지 로드 시 실행
document.addEventListener("DOMContentLoaded", () => {
  // 사용자 인증 상태에 따라 UI 업데이트
  const user = TaxiShare.auth.getUser()
  const loginButtons = document.querySelectorAll('[data-auth="login"]')
  const userButtons = document.querySelectorAll('[data-auth="user"]')

  if (user) {
    loginButtons.forEach((btn) => (btn.style.display = "none"))
    userButtons.forEach((btn) => (btn.style.display = "block"))
  } else {
    loginButtons.forEach((btn) => (btn.style.display = "block"))
    userButtons.forEach((btn) => (btn.style.display = "none"))
  }
})
