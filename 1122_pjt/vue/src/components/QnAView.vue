<template>
    <div>
        <h2 style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp;QnA 상세</h2>
        <div class="container" style="width: 40%;">
		<form action="http://localhost:8090/api/notice/update" method="put">
		<table class="table table-striped">
			<tr>
				<th style="text-align: center;">제 목</th>
			</tr>
			<tr>
				<td>
				<input type="text" name="btitle" required="required" style="width:720px" v-model="notice.title" >
				</td>
			</tr>
			<tr>
				<th style="text-align: center;">내 용</th>
			</tr>
			<tr>
				<td><textarea name="bcontent" rows="15" cols="100" required="required" v-model="notice.content">  </textarea></td>
			</tr>
			<tr>
			</tr>
		</table>
		<button type="button" class="btn btn-group btn-default btn-animated" v-on:click="deleteQnA(notice.bno)">삭 제</button>
		<button type="button" class="btn btn-primary btn-block pull-right" v-on:click="update(notice)" style="width:70px;">수 정</button>
		<input type="text" name="bno" value="${notice.bno }" style="visibility:hidden">
        <h3 style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp;QnA 답변</h3>

        <table class="table table-striped">			
			<tr>
				<th style="text-align: center;">내 용</th>
			</tr>
			<tr>
				<td><textarea name="bcontent" rows="15" cols="100" required="required" v-model="notice.qcontent">  </textarea></td>
			</tr>
			<tr>
			</tr>
		</table>
		<!-- <button type="reset" class="btn btn-group btn-default btn-animated" onclick="noticeDelete()">삭 제</button> -->
		<button type="button" class="btn btn-primary btn-block pull-right" v-on:click="update(notice)" style="width:70px;">수 정</button>


		</form>
		<br><br><br><br>
	</div>
    </div>
    
</template>

<script>
import 'http'
import http from "../http-common";
import axios from 'axios';



export default {
    name: "Foodchart",
    props: ["no"],
  data() {
    return {
      
      upHere: false,
      notice: null,
      loading: true,
      errored: false
    };
  },
    methods:{
        getMainList(){
            http
              .get("localhost:8090/list")
              .then(response => (this.info = response.list))
              .catch(()=>{
                  this.errored = true;
              })
        },
        getImg(pic){
          return require('../assets/'+pic)
        },
        getNotice: function() {                        
            axios.post('http://localhost:8090/api/qna/qnaview', 
                        {bno : this.no}
                        ).then(response => (this.notice = response.data.resValue))
                   .catch(()=>{
                       this.errored = true;

                     })
            
            // http
            //       .post("http://localhost:8090/api/notice/noticeview?bno="+this.no)
            //       .data
            //       .then(response => (this.notice = response.data.resValue))
            //       .catch(()=>{
            //           this.errored = true;

            //         })
            //alert(this.code);
        },
        goNoticeView(no){
          this.$router.push("/noticeview/" + no);
          return;
        },
        deleteQnA(no){
            alert(no);
            axios.delete('http://localhost:8090/api/qna/delete/'+no
                        
                        ).then()
                   .catch(()=>{
                       this.errored = true;

                     })
                    .finally(()=>{
                        this.$router.push("/QnA");
                    })
        },
        update(no){
            alert(no.title);
            axios.put('http://localhost:8090/api/qna/update',
                    no
                 ).then()
                   .catch(()=>{
                       this.errored = true;

                     })
                    .finally(()=>{
                        this.$router.push("/QnA");
                    })
        }
        
    },

  mounted(){
    this.getNotice();
      
  }


}
</script>