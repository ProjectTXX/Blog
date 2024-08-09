<template>
  <div class="announcement-board">
    <div class="important-notices">
      <h3>📣 重要通知 📣</h3>
      <p>这里是重要通知的内容</p>
    </div>
    <div class="welcome-message">
      <h3>🎉 欢迎信息 🎉</h3>
      <p>
        欢迎来自 <span class="location">{{ location }}</span> 的小伙伴！您现在距离站长约
        <span class="distance">{{ distance }}</span> 公里，当前的IP地址为：
        <span class="ip">{{ ip }}</span>
      </p>
    </div>
  </div>
</template>

<!-- <script>
import axios from 'axios';

export default {
  name: 'AnnouncementBoard',
  data() {
    return {
      location: '',
      distance: '',
      ip: ''
    };
  },
  created() {
    this.fetchUserInfo();
  },
  methods: {
    fetchUserInfo() {  // 获取用户信息
      axios.get('http://localhost:5000/api/userinfo')
        .then(response => {
          this.location = response.data.location;
          this.distance = response.data.distance;
          this.ip = response.data.ip;
        })
        .catch(error => {
          console.error('获取用户信息时出错：', error); 
        });
    },
  },
};
</script> -->

<script>
import axios from 'axios';

export default {
  name: 'AnnouncementBoard',
  data() {
    return {
      location: '', // 用户位置
      distance: '', // 用户到株洲的距离
      ip: '',       // 用户IP
    };
  },
  created() {
    this.getUserInfo();
  },
  methods: {
    getUserInfo() {
      this.getIP();
      this.getUserLocation();
    },
    getIP() {
      axios.get('https://api.ipify.org?format=json')
        .then(response => {
          this.ip = response.data.ip;
        })
        .catch(error => {
          console.error('Error fetching IP:', error);
        });
    },
    getUserLocation() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(this.setLocation, this.showError);
      } else {
        console.error('Geolocation is not supported by this browser.');
      }
    },
    setLocation(position) {
      const lat = position.coords.latitude;
      const lon = position.coords.longitude;
      const amapKey = 'ac4e0bd5f63792a820147e124fe71fe5'
      
      // 使用高德地图 API 获取可读位置
      axios.get(`https://restapi.amap.com/v3/geocode/regeo?location=${lon},${lat}&key=${amapKey}`)
        .then(response => {
          if (response.data.status === '1') {
          console.log(response.data);
          
            const location = response.data.regeocode.formatted_address;
            this.location = location;

            // 株洲的地理坐标
            const zhuzhouLat = 27.8276;
            const zhuzhouLon = 113.1332;
            this.distance = this.calculateDistance(lat, lon, zhuzhouLat, zhuzhouLon);
          } else {
            console.error('Error fetching location from Amap:', response.data.info);
          }
        })
        .catch(error => {
          console.error('Error fetching location:', error);
        });
    },
    showError(error) {
      switch(error.code) {
        case error.PERMISSION_DENIED:
          console.error('User denied the request for Geolocation.');
          break;
        case error.POSITION_UNAVAILABLE:
          console.error('Location information is unavailable.');
          break;
        case error.TIMEOUT:
          console.error('The request to get user location timed out.');
          break;
        case error.UNKNOWN_ERROR:
          console.error('An unknown error occurred.');
          break;
      }
    },
    calculateDistance(lat1, lon1, lat2, lon2) {
      const R = 6371; // 地球半径，单位为公里
      const dLat = this.deg2rad(lat2 - lat1);
      const dLon = this.deg2rad(lon2 - lon1);
      const a = 
        Math.sin(dLat/2) * Math.sin(dLat/2) +
        Math.cos(this.deg2rad(lat1)) * Math.cos(this.deg2rad(lat2)) * 
        Math.sin(dLon/2) * Math.sin(dLon/2);
      const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
      const distance = R * c; // 距离，单位为公里
      return distance.toFixed(2);
    },
    deg2rad(deg) {
      return deg * (Math.PI/180);
    },
  },
};

</script>

<style scoped>
.announcement-board {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.important-notices,
.welcome-message {
  background-color: rgba(229, 244, 243, 1);
  border-radius: 10px;
  padding: 1rem;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  margin: 1rem;
}

.important-notices h3,
.welcome-message h3 {
  text-align: center;
}

.location {
  color: blue;
}

.distance {
  color: green;
}

.ip {
  color: red;
}
</style>
