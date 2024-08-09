<template>
  <div class="comment-section">
    <!-- 评论表单 -->
    <div class="comment-form">
      <textarea v-model="newComment" placeholder="评论千万条，友善第一条" maxlength="250"></textarea>
      <button @click="submitComment" class="submit-button">发表评论</button>
    </div>

    <!-- 评论标题和总数 -->
    <h2>Comments | 共{{ totalComments }}条评论</h2>

    <!-- 评论列表 -->
    <div class="comment-list">
      <div v-for="comment in paginatedComments" :key="comment.id" class="comment">
        <img :src="comment.avatar" alt="Avatar" class="avatar">
        <div class="comment-content">
          <div class="comment-header">
            <span class="username">{{ comment.username }}</span>
            <span class="date">{{ formatDate(comment.date) }}</span>
          </div>
          <div class="comment-body">{{ comment.content }}</div>
          <div class="comment-actions">
            <button @click="replyToComment(comment)" class="reply-button">回复</button>
            <button v-if="comment.username === currentUser" @click="deleteComment(comment.id)" class="delete-button">删除</button>
          </div>

          <!-- 回复区 -->
          <div v-if="comment.replies && comment.replies.length > 0" class="replies">
            <div v-for="reply in comment.replies" :key="reply.id" class="comment reply">
              <img :src="reply.avatar" alt="Avatar" class="avatar">
              <div class="comment-content">
                <div class="comment-header">
                  <span class="username">{{ reply.username }}</span>
                  <span class="date">{{ formatDate(reply.date) }}</span>
                </div>
                <div class="comment-body">{{ reply.content }}</div>
                <div class="comment-actions">
                  <button @click="replyToComment(comment, reply)" class="reply-button">回复</button>
                  <button v-if="reply.username === currentUser" @click="deleteComment(reply.id)" class="delete-button">删除</button>
                </div>

                <!-- 递归处理回复的回复 -->
                <div v-if="reply.replies && reply.replies.length > 0" class="replies">
                  <div v-for="subReply in reply.replies" :key="subReply.id" class="comment reply">
                    <img :src="subReply.avatar" alt="Avatar" class="avatar">
                    <div class="comment-content">
                      <div class="comment-header">
                        <span class="username">{{ subReply.username }}</span>
                        <span class="date">{{ formatDate(subReply.date) }}</span>
                      </div>
                      <div class="comment-body">{{ subReply.content }}</div>
                      <div class="comment-actions">
                        <button @click="replyToComment(comment, subReply)" class="reply-button">回复</button>
                        <button v-if="subReply.username === currentUser" @click="deleteComment(subReply.id)" class="delete-button">删除</button>
                      </div>
                    </div>
                  </div>
                </div>

              </div>
            </div>
          </div>

        </div>
      </div>
    </div>

    <!-- 分页组件 -->
    <CommentPagination :total="parentComments.length" :current="currentPage" @page-changed="handlePageChange" />
  </div>
</template>

<script>
// 导入必要的组件和方法
import CommentPagination from './CommentPagination.vue';
import { Fetch } from '@/api/comments/Fetch';
import { Add } from '@/api/comments/Add';
import { Delete } from '@/api/comments/Delete';

export default {
  components: {
    CommentPagination
  },
  data() {
    return {
      comments: [
        {
          id: 1,
          username: 'user1',
          avatar: '',
          content: '这是第1个评论',
          date: '2024-08-07 12:00',
          replies: [
            {
              id: 2,
              username: 'user2',
              avatar: '',
              content: '这是对第1个评论的回复',
              date: '2024-08-07 12:05',
              replies: []
            },
            {
              id: 3,
              username: 'admin',
              avatar: '',
              content: '这是对第1个回复的回复',
              date: '2024-08-07 12:10',
              replies: []
            }
          ]
        },
        {
          id: 4,
          username: 'user3',
          avatar: '',
          content: '这是第2个评论',
          date: '2024-08-07 12:15',
          replies: []
        },
        {
          id: 5,
          username: 'user4',
          avatar: '',
          content: '这是第3个评论',
          date: '2024-08-07 12:15',
          replies: []
        },
        {
          id: 6,
          username: 'user5',
          avatar: '',
          content: '这是第4个评论',
          date: '2024-08-07 12:15',
          replies: []
        },
        {
          id: 7,
          username: 'user6',
          avatar: '',
          content: '这是第5个评论',
          date: '2024-08-07 12:15',
          replies: []
        },
        {
          id: 8,
          username: 'user7',
          avatar: '',
          content: '这是第6个评论',
          date: '2024-08-07 12:15',
          replies: []
        }
      ],
      newComment: '',
      currentUser: 'admin', // 动态用户获取
      currentPage: 1,
      commentsPerPage: 5
    };
  },
  computed: {
    totalComments() {
      return this.comments.reduce((count, comment) => {
        return count + 1 + this.countReplies(comment);
      }, 0);
    },
    parentComments() {
      return this.comments.filter(comment => !comment.parentId);
    },
    paginatedComments() {
      const start = (this.currentPage - 1) * this.commentsPerPage;
      const end = start + this.commentsPerPage;
      return this.sortedParentComments.slice(start, end);
    },
    sortedParentComments() {
      return [...this.parentComments].sort((a, b) => new Date(b.date) - new Date(a.date));
    }
  },
  created() {
    this.fetchComments();
  },
  methods: {
    fetchComments() { 
      Fetch().then(response => {      //axios调用
        const comments = response.data;
        const commentMap = {};
        comments.forEach(comment => {
          comment.replies = [];
          commentMap[comment.id] = comment;
        });
        comments.forEach(comment => {
          if (comment.parentId) {
            commentMap[comment.parentId].replies.push(comment);
          } else {
            this.comments.push(comment);
          }
        });
      }).catch(error => {
        console.error('获取评论时出错：', error);
      });
    },
    deleteComment(commentId) {
      Delete({ commentId }).then(() => {      //axios调用
        this.comments = this.comments.filter(comment => comment.id !== commentId);
        this.comments.forEach(comment => {
          if (comment.replies) {
            comment.replies = comment.replies.filter(reply => reply.id !== commentId);
          }
        });
      }).catch(error => {
        console.error('删除评论时出错：', error);
      });
    },
    formatDate(date) {
      const d = new Date(date);
      return `${d.getFullYear()}-${('0' + (d.getMonth() + 1)).slice(-2)}-${('0' + d.getDate()).slice(-2)} ${('0' + d.getHours()).slice(-2)}:${('0' + d.getMinutes()).slice(-2)}`;
    },
    replyToComment(parentComment, replyComment = null) {
      const username = replyComment ? replyComment.username : parentComment.username;
      this.newComment = `@${username} `;
    },
    submitComment() {
      if (this.newComment.trim()) {
        const parentComment = this.newComment.includes('@') ? this.getCommentByMention(this.newComment) : null;
        const newComment = {
          username: this.currentUser,
          avatar: '',
          content: this.newComment,
          date: new Date(),
          parentId: parentComment ? parentComment.id : null
        };
        Add({ newComment }).then(response => {      //axios调用
          if (parentComment) {
            parentComment.replies.push(response.data);
          } else {
            this.comments.push(response.data);
          }
          this.newComment = '';
        }).catch(error => {
          console.error('发布评论时出错：', error);
        });
      }
    },
    getCommentByMention(content) {
      const mention = content.match(/@(\w+)/);
      if (mention) {
        const username = mention[1];
        return this.comments.find(comment => comment.username === username);
      }
      return null;
    },
    countReplies(comment) {
      if (comment.replies && comment.replies.length > 0) {
        return comment.replies.length + comment.replies.reduce((count, reply) => count + this.countReplies(reply), 0);
      }
      return 0;
    },
    handlePageChange(newPage) {
      this.currentPage = newPage;
    }
  }
};
</script>

<style scoped>
.comment-section {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f4f6f8;
  border-radius: 12px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.comment-list {
  margin-bottom: 20px;
}

.comment {
  display: flex;
  align-items: flex-start;
  margin-bottom: 20px;
  padding: 15px;
  border-bottom: 1px solid #e0e0e0;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
}

.comment:last-child {
  border-bottom: none;
}

.avatar {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  margin-right: 15px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.comment-content {
  flex: 1;
  background: #ffffff;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
}

.comment-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.username {
  font-weight: 600;
  color: #333333;
  font-size: 1em;
}

.date {
  font-size: 0.85em;
  color: #888888;
}

.comment-body {
  margin-bottom: 10px;
  line-height: 1.5;
  color: #555555;
}

.comment-actions {
  display: flex;
  gap: 15px;
  font-size: 0.9em;
}

.reply-button, .delete-button {
  background-color: #007bff;
  color: #ffffff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 0.85em;
  padding: 8px 15px;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.reply-button:hover, .delete-button:hover {
  background-color: #0056b3;
  transform: translateY(-2px);
}

.reply-button:active, .delete-button:active {
  background-color: #004494;
  transform: translateY(0);
}

.replies {
  margin-left: 0;
  margin-top: 10px;
  padding-left: 0;
}

.comment-form {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  margin-bottom: 20px;
}

textarea {
  width: 97%;
  height: 120px;
  margin-bottom: 10px;
  padding: 12px;
  border-radius: 6px;
  border: 1px solid #ddd;
  box-shadow: inset 0 1px 3px rgba(0,0,0,0.1);
  resize: none;
  font-size: 0.95em;
  color: #333;
}

.submit-button {
  background-color: #007bff;
  color: #ffffff;
  border: none;
  border-radius: 6px;
  padding: 10px 20px;
  cursor: pointer;
  font-size: 1em;
  font-weight: 600;
  transition: background-color 0.3s ease;
}

.submit-button:hover {
  background-color: #0056b3;
}

.submit-button:active {
  background-color: #004494;
}
</style>
