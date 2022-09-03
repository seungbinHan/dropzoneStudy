# dropzoneStudy

공부한 계기 : 
드랍존으로 파일과 텍스트를 동시에 보내는것을 하고싶었다.
그러나 드랍존의 기본 설정은 파일만 보내는것이었고,
텍스트도 같이 백단으로 보내면서 헤더에 토큰도 담을 방법을 찾았으나 찾지 못하다가 
집에서의 며칠간의 삽질로 해결했다.(여기서는 헤더에 토큰을담아 테스트해보진 않았지만, 드랍존 옵션중 headers 라는 옵션에다가 js 객체로 헤더를 담아주면 될듯함)

해결하고보니 공식문서에 다 있는 내용이었고, 좀 허무햇음

import
```
<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
<link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css"/>
```

html
```
<form action="/recieveDropzone"
          class="dropzone" // class에 dropzone만 줘도 알아서 드랍존 적용됨
          id="my-awesome-dropzone">
        <input type="text" name="title">
</form >
<input type="button" value="서브밋!" id="sendBtn">
```

script

```
<script>
    Dropzone.options.myAwesomeDropzone = { //form의 id 를 카멜케이스화 해서 적은것임.
        autoProcessQueue: false
        ,header:{
            "My-Awesome-Header": "header value"
        }
        ,init:function (){
            let myDropzone = this;
            $("#sendBtn").on("click",function (){
                myDropzone.processQueue();
            });
        }
    }
<script>
```
    
spring
```

    @ResponseBody
    @PostMapping(value = "/recieveDropzone")
    //public String dropzone(@RequestParam HashMap<String,Object> formData){
    public String dropzone(@RequestParam MultipartFile file,
                           @RequestParam(required = false) String title){
        System.out.println("file = " + file + ", title = " + title);
        return "returnMessage";
    }
```
    
